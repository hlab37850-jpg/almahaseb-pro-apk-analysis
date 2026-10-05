package defpackage;

/* JADX INFO: renamed from: Rj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0884Rj implements InterfaceC0939Tm {
    public final InterfaceC0939Tm a;
    public final InterfaceC3750qp b;
    public final InterfaceC0526Fp c;

    /* JADX INFO: renamed from: Rj$a */
    public static final class a implements InterfaceC0995Vm {
        public final /* synthetic */ OJ b;
        public final /* synthetic */ InterfaceC0995Vm c;

        /* JADX INFO: renamed from: Rj$a$a, reason: collision with other inner class name */
        public static final class C0015a extends AbstractC0819Pf {
            public /* synthetic */ Object a;
            public int c;

            public C0015a(InterfaceC0793Of interfaceC0793Of) {
                super(interfaceC0793Of);
            }

            @Override // defpackage.AbstractC2171f7
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.c |= Integer.MIN_VALUE;
                return a.this.emit(null, this);
            }
        }

        public a(OJ oj, InterfaceC0995Vm interfaceC0995Vm) {
            this.b = oj;
            this.c = interfaceC0995Vm;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // defpackage.InterfaceC0995Vm
        public final Object emit(Object obj, InterfaceC0793Of interfaceC0793Of) throws Throwable {
            C0015a c0015a;
            if (interfaceC0793Of instanceof C0015a) {
                c0015a = (C0015a) interfaceC0793Of;
                int i = c0015a.c;
                if ((i & Integer.MIN_VALUE) != 0) {
                    c0015a.c = i - Integer.MIN_VALUE;
                } else {
                    c0015a = new C0015a(interfaceC0793Of);
                }
            } else {
                c0015a = new C0015a(interfaceC0793Of);
            }
            Object obj2 = c0015a.a;
            Object objD = AbstractC0378Bt.d();
            int i2 = c0015a.c;
            if (i2 == 0) {
                LL.b(obj2);
                Object objInvoke = C0884Rj.this.b.invoke(obj);
                Object obj3 = this.b.a;
                if (obj3 != VD.a && ((Boolean) C0884Rj.this.c.mo13invoke(obj3, objInvoke)).booleanValue()) {
                    return FW.a;
                }
                this.b.a = objInvoke;
                InterfaceC0995Vm interfaceC0995Vm = this.c;
                c0015a.c = 1;
                if (interfaceC0995Vm.emit(obj, c0015a) == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj2);
            }
            return FW.a;
        }
    }

    public C0884Rj(InterfaceC0939Tm interfaceC0939Tm, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp) {
        this.a = interfaceC0939Tm;
        this.b = interfaceC3750qp;
        this.c = interfaceC0526Fp;
    }

    @Override // defpackage.InterfaceC0939Tm
    public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        OJ oj = new OJ();
        oj.a = VD.a;
        Object objCollect = this.a.collect(new a(oj, interfaceC0995Vm), interfaceC0793Of);
        return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
    }
}
