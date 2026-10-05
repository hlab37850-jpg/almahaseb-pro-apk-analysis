package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AM {

    public static final class a implements FQ {
        public final /* synthetic */ InterfaceC4293xa a;

        public a(InterfaceC4293xa interfaceC4293xa) {
            this.a = interfaceC4293xa;
        }

        @Override // defpackage.FQ
        public void a(InterfaceC0624Jj interfaceC0624Jj) {
            AM.c(this.a, interfaceC0624Jj);
        }

        @Override // defpackage.FQ
        public void onError(Throwable th) {
            InterfaceC4293xa interfaceC4293xa = this.a;
            KL.a aVar = KL.a;
            interfaceC4293xa.resumeWith(KL.a(LL.a(th)));
        }

        @Override // defpackage.FQ
        public void onSuccess(Object obj) {
            this.a.resumeWith(KL.a(obj));
        }
    }

    public static final class b implements InterfaceC2096eB {
        public final /* synthetic */ InterfaceC4293xa a;

        public b(InterfaceC4293xa interfaceC4293xa) {
            this.a = interfaceC4293xa;
        }
    }

    public static final class c extends AbstractC2233fv implements InterfaceC3750qp {
        public final /* synthetic */ InterfaceC0624Jj a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterfaceC0624Jj interfaceC0624Jj) {
            super(1);
            this.a = interfaceC0624Jj;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return FW.a;
        }

        public final void invoke(Throwable th) {
            this.a.dispose();
        }
    }

    public static final Object a(IQ iq, InterfaceC0793Of interfaceC0793Of) {
        C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        iq.a(new a(c4374ya));
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    public static final Object b(InterfaceC2178fB interfaceC2178fB, InterfaceC0793Of interfaceC0793Of) {
        C4374ya c4374ya = new C4374ya(AbstractC0352At.c(interfaceC0793Of), 1);
        c4374ya.A();
        interfaceC2178fB.a(new b(c4374ya));
        Object objX = c4374ya.x();
        if (objX == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objX;
    }

    public static final void c(InterfaceC4293xa interfaceC4293xa, InterfaceC0624Jj interfaceC0624Jj) {
        interfaceC4293xa.e(new c(interfaceC0624Jj));
    }
}
