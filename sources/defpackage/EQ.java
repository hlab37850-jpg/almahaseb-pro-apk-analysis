package defpackage;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class EQ extends BQ {
    public final IQ a;
    public final InterfaceC0777Np b;

    public static final class a implements FQ {
        public final FQ a;
        public final InterfaceC0777Np b;

        public a(FQ fq, InterfaceC0777Np interfaceC0777Np) {
            this.a = fq;
            this.b = interfaceC0777Np;
        }

        @Override // defpackage.FQ
        public void a(InterfaceC0624Jj interfaceC0624Jj) {
            this.a.a(interfaceC0624Jj);
        }

        @Override // defpackage.FQ
        public void onError(Throwable th) {
            this.a.onError(th);
        }

        @Override // defpackage.FQ
        public void onSuccess(Object obj) {
            try {
                Object objApply = this.b.apply(obj);
                Objects.requireNonNull(objApply, "The mapper function returned a null value.");
                this.a.onSuccess(objApply);
            } catch (Throwable th) {
                AbstractC0722Ll.b(th);
                onError(th);
            }
        }
    }

    public EQ(IQ iq, InterfaceC0777Np interfaceC0777Np) {
        this.a = iq;
        this.b = interfaceC0777Np;
    }

    @Override // defpackage.BQ
    public void f(FQ fq) {
        this.a.a(new a(fq, this.b));
    }
}
