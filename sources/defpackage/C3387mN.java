package defpackage;

/* JADX INFO: renamed from: mN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C3387mN extends AbstractC0819Pf implements InterfaceC0995Vm, InterfaceC2297gg {
    public final InterfaceC0995Vm a;
    public final InterfaceC0988Vf b;
    public final int c;
    public InterfaceC0988Vf d;
    public InterfaceC0793Of e;

    /* JADX INFO: renamed from: mN$a */
    public static final class a extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final a a = new a();

        public a() {
            super(2);
        }

        public final Integer a(int i, InterfaceC0988Vf.b bVar) {
            return Integer.valueOf(i + 1);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (InterfaceC0988Vf.b) obj2);
        }
    }

    public C3387mN(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0988Vf interfaceC0988Vf) {
        super(C4442zD.a, C1172Zk.a);
        this.a = interfaceC0995Vm;
        this.b = interfaceC0988Vf;
        this.c = ((Number) interfaceC0988Vf.fold(0, a.a)).intValue();
    }

    @Override // defpackage.InterfaceC0995Vm
    public Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) {
        try {
            Object objP = p(interfaceC0793Of, obj);
            if (objP == AbstractC0378Bt.d()) {
                AbstractC3416mi.c(interfaceC0793Of);
            }
            return objP == AbstractC0378Bt.d() ? objP : FW.a;
        } catch (Throwable th) {
            this.d = new C1820bk(th, interfaceC0793Of.getContext());
            throw th;
        }
    }

    @Override // defpackage.AbstractC2171f7, defpackage.InterfaceC2297gg
    public InterfaceC2297gg getCallerFrame() {
        InterfaceC0793Of interfaceC0793Of = this.e;
        if (interfaceC0793Of instanceof InterfaceC2297gg) {
            return (InterfaceC2297gg) interfaceC0793Of;
        }
        return null;
    }

    @Override // defpackage.AbstractC0819Pf, defpackage.InterfaceC0793Of
    public InterfaceC0988Vf getContext() {
        InterfaceC0988Vf interfaceC0988Vf = this.d;
        return interfaceC0988Vf == null ? C1172Zk.a : interfaceC0988Vf;
    }

    @Override // defpackage.AbstractC2171f7
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // defpackage.AbstractC2171f7
    public Object invokeSuspend(Object obj) {
        Throwable thB = KL.b(obj);
        if (thB != null) {
            this.d = new C1820bk(thB, getContext());
        }
        InterfaceC0793Of interfaceC0793Of = this.e;
        if (interfaceC0793Of != null) {
            interfaceC0793Of.resumeWith(obj);
        }
        return AbstractC0378Bt.d();
    }

    public final void l(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0988Vf interfaceC0988Vf2, Object obj) {
        if (interfaceC0988Vf2 instanceof C1820bk) {
            q((C1820bk) interfaceC0988Vf2, obj);
        }
        AbstractC3551oN.a(this, interfaceC0988Vf);
    }

    public final Object p(InterfaceC0793Of interfaceC0793Of, Object obj) {
        InterfaceC0988Vf context = interfaceC0793Of.getContext();
        AbstractC3347lu.j(context);
        InterfaceC0988Vf interfaceC0988Vf = this.d;
        if (interfaceC0988Vf != context) {
            l(context, interfaceC0988Vf, obj);
            this.d = context;
        }
        this.e = interfaceC0793Of;
        Object objInvoke = AbstractC3469nN.a.invoke(this.a, obj, this);
        if (!AbstractC4492zt.d(objInvoke, AbstractC0378Bt.d())) {
            this.e = null;
        }
        return objInvoke;
    }

    public final void q(C1820bk c1820bk, Object obj) {
        throw new IllegalStateException(AbstractC3310lS.f("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + c1820bk.a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // defpackage.AbstractC0819Pf, defpackage.AbstractC2171f7
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
