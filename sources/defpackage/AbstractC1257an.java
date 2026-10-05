package defpackage;

/* JADX INFO: renamed from: an, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC1257an {

    /* JADX INFO: renamed from: an$a */
    public static final class a extends XS implements InterfaceC0526Fp {
        public int a;
        public final /* synthetic */ InterfaceC0939Tm b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.b = interfaceC0939Tm;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new a(this.b, interfaceC0793Of);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC2052dg interfaceC2052dg, InterfaceC0793Of interfaceC0793Of) {
            return ((a) create(interfaceC2052dg, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.a;
            if (i == 0) {
                LL.b(obj);
                InterfaceC0939Tm interfaceC0939Tm = this.b;
                this.a = 1;
                if (AbstractC1047Xm.f(interfaceC0939Tm, this) == objD) {
                    return objD;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                LL.b(obj);
            }
            return FW.a;
        }
    }

    public static final Object a(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0793Of interfaceC0793Of) {
        Object objCollect = interfaceC0939Tm.collect(ED.a, interfaceC0793Of);
        return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
    }

    public static final Object b(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        Object objF = AbstractC1047Xm.f(AbstractC1823bn.b(AbstractC1047Xm.w(interfaceC0939Tm, interfaceC0526Fp), 0, null, 2, null), interfaceC0793Of);
        return objF == AbstractC0378Bt.d() ? objF : FW.a;
    }

    public static final Object c(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0939Tm interfaceC0939Tm, InterfaceC0793Of interfaceC0793Of) {
        AbstractC1047Xm.o(interfaceC0995Vm);
        Object objCollect = interfaceC0939Tm.collect(interfaceC0995Vm, interfaceC0793Of);
        return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
    }

    public static final InterfaceC1830bu d(InterfaceC0939Tm interfaceC0939Tm, InterfaceC2052dg interfaceC2052dg) {
        return O8.d(interfaceC2052dg, null, null, new a(interfaceC0939Tm, null), 3, null);
    }
}
