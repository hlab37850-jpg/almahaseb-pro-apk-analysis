package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class M implements InterfaceC0939Tm {

    public static final class a extends AbstractC0819Pf {
        public Object a;
        public /* synthetic */ Object b;
        public int d;

        public a(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return M.this.collect(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // defpackage.InterfaceC0939Tm
    public final Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        a aVar;
        Throwable th;
        C3387mN c3387mN;
        if (interfaceC0793Of instanceof a) {
            aVar = (a) interfaceC0793Of;
            int i = aVar.d;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.d = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(interfaceC0793Of);
            }
        } else {
            aVar = new a(interfaceC0793Of);
        }
        Object obj = aVar.b;
        Object objD = AbstractC0378Bt.d();
        int i2 = aVar.d;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c3387mN = (C3387mN) aVar.a;
            try {
                LL.b(obj);
                c3387mN.releaseIntercepted();
                return FW.a;
            } catch (Throwable th2) {
                th = th2;
                c3387mN.releaseIntercepted();
                throw th;
            }
        }
        LL.b(obj);
        C3387mN c3387mN2 = new C3387mN(interfaceC0995Vm, aVar.getContext());
        try {
            aVar.a = c3387mN2;
            aVar.d = 1;
            if (d(c3387mN2, aVar) == objD) {
                return objD;
            }
            c3387mN = c3387mN2;
            c3387mN.releaseIntercepted();
            return FW.a;
        } catch (Throwable th3) {
            th = th3;
            c3387mN = c3387mN2;
            c3387mN.releaseIntercepted();
            throw th;
        }
    }

    public abstract Object d(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of);
}
