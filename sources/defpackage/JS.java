package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public final class JS implements InterfaceC0995Vm {
    public final InterfaceC0995Vm a;
    public final InterfaceC0526Fp b;

    public static final class a extends AbstractC0819Pf {
        public Object a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public a(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return JS.this.a(this);
        }
    }

    public JS(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0526Fp interfaceC0526Fp) {
        this.a = interfaceC0995Vm;
        this.b = interfaceC0526Fp;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [mN] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    public final Object a(InterfaceC0793Of interfaceC0793Of) throws Throwable {
        a aVar;
        C3387mN c3387mN;
        JS js;
        if (interfaceC0793Of instanceof a) {
            aVar = (a) interfaceC0793Of;
            int i = aVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.e = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(interfaceC0793Of);
            }
        } else {
            aVar = new a(interfaceC0793Of);
        }
        Object obj = aVar.c;
        Object objD = AbstractC0378Bt.d();
        ?? r2 = aVar.e;
        try {
            if (r2 != 0) {
                if (r2 == 1) {
                    c3387mN = (C3387mN) aVar.b;
                    js = (JS) aVar.a;
                    LL.b(obj);
                } else {
                    if (r2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                return FW.a;
            }
            LL.b(obj);
            c3387mN = new C3387mN(this.a, aVar.getContext());
            InterfaceC0526Fp interfaceC0526Fp = this.b;
            aVar.a = this;
            aVar.b = c3387mN;
            aVar.e = 1;
            if (interfaceC0526Fp.mo13invoke(c3387mN, aVar) == objD) {
                return objD;
            }
            js = this;
            c3387mN.releaseIntercepted();
            InterfaceC0995Vm interfaceC0995Vm = js.a;
            r2 = interfaceC0995Vm instanceof JS;
            if (r2 == 0) {
                return FW.a;
            }
            aVar.a = null;
            aVar.b = null;
            aVar.e = 2;
            if (((JS) interfaceC0995Vm).a(aVar) == objD) {
                return objD;
            }
            return FW.a;
        } catch (Throwable th) {
            r2.releaseIntercepted();
            throw th;
        }
    }

    @Override // defpackage.InterfaceC0995Vm
    public Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) {
        return this.a.emit(obj, interfaceC0793Of);
    }
}
