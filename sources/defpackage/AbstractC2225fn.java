package defpackage;

/* JADX INFO: renamed from: fn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC2225fn {
    public static final int a = AbstractC3557oT.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    /* JADX INFO: renamed from: fn$a */
    public static final class a extends XS implements InterfaceC0552Gp {
        public int a;
        public /* synthetic */ Object b;
        public /* synthetic */ Object c;
        public final /* synthetic */ InterfaceC0526Fp d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
            super(3, interfaceC0793Of);
            this.d = interfaceC0526Fp;
        }

        @Override // defpackage.InterfaceC0552Gp
        public final Object invoke(InterfaceC0995Vm interfaceC0995Vm, Object obj, InterfaceC0793Of interfaceC0793Of) {
            a aVar = new a(this.d, interfaceC0793Of);
            aVar.b = interfaceC0995Vm;
            aVar.c = obj;
            return aVar.invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC0995Vm interfaceC0995Vm;
            Object objD = AbstractC0378Bt.d();
            int i = this.a;
            if (i != 0) {
                if (i == 1) {
                    interfaceC0995Vm = (InterfaceC0995Vm) this.b;
                    LL.b(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    LL.b(obj);
                }
                return FW.a;
            }
            LL.b(obj);
            interfaceC0995Vm = (InterfaceC0995Vm) this.b;
            Object obj2 = this.c;
            InterfaceC0526Fp interfaceC0526Fp = this.d;
            this.b = interfaceC0995Vm;
            this.a = 1;
            obj = interfaceC0526Fp.mo13invoke(obj2, this);
            if (obj == objD) {
                return objD;
            }
            this.b = null;
            this.a = 2;
            if (interfaceC0995Vm.emit(obj, this) == objD) {
                return objD;
            }
            return FW.a;
        }
    }

    public static final InterfaceC0939Tm a(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0526Fp interfaceC0526Fp) {
        return AbstractC1047Xm.H(interfaceC0939Tm, new a(interfaceC0526Fp, null));
    }

    public static final InterfaceC0939Tm b(Iterable iterable) {
        return new C2369hb(iterable, null, 0, null, 14, null);
    }

    public static final InterfaceC0939Tm c(InterfaceC0939Tm... interfaceC0939TmArr) {
        return AbstractC1047Xm.x(R5.B(interfaceC0939TmArr));
    }

    public static final InterfaceC0939Tm d(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0552Gp interfaceC0552Gp) {
        return new C2123eb(interfaceC0552Gp, interfaceC0939Tm, null, 0, null, 28, null);
    }
}
