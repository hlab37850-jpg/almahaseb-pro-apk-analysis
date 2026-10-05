package defpackage;

/* JADX INFO: renamed from: cb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1884cb extends AbstractC1162Za {
    public final InterfaceC0939Tm d;

    /* JADX INFO: renamed from: cb$a */
    public static final class a extends XS implements InterfaceC0526Fp {
        public int a;
        public /* synthetic */ Object b;

        public a(InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            a aVar = AbstractC1884cb.this.new a(interfaceC0793Of);
            aVar.b = obj;
            return aVar;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
            return ((a) create(interfaceC0995Vm, interfaceC0793Of)).invokeSuspend(FW.a);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objD = AbstractC0378Bt.d();
            int i = this.a;
            if (i == 0) {
                LL.b(obj);
                InterfaceC0995Vm interfaceC0995Vm = (InterfaceC0995Vm) this.b;
                AbstractC1884cb abstractC1884cb = AbstractC1884cb.this;
                this.a = 1;
                if (abstractC1884cb.q(interfaceC0995Vm, this) == objD) {
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

    public AbstractC1884cb(InterfaceC0939Tm interfaceC0939Tm, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        super(interfaceC0988Vf, i, i8);
        this.d = interfaceC0939Tm;
    }

    public static /* synthetic */ Object n(AbstractC1884cb abstractC1884cb, InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        if (abstractC1884cb.b == -3) {
            InterfaceC0988Vf context = interfaceC0793Of.getContext();
            InterfaceC0988Vf interfaceC0988VfPlus = context.plus(abstractC1884cb.a);
            if (AbstractC4492zt.d(interfaceC0988VfPlus, context)) {
                Object objQ = abstractC1884cb.q(interfaceC0995Vm, interfaceC0793Of);
                return objQ == AbstractC0378Bt.d() ? objQ : FW.a;
            }
            InterfaceC0854Qf.b bVar = InterfaceC0854Qf.o;
            if (AbstractC4492zt.d(interfaceC0988VfPlus.get(bVar), context.get(bVar))) {
                Object objP = abstractC1884cb.p(interfaceC0995Vm, interfaceC0988VfPlus, interfaceC0793Of);
                return objP == AbstractC0378Bt.d() ? objP : FW.a;
            }
        }
        Object objCollect = super.collect(interfaceC0995Vm, interfaceC0793Of);
        return objCollect == AbstractC0378Bt.d() ? objCollect : FW.a;
    }

    public static /* synthetic */ Object o(AbstractC1884cb abstractC1884cb, InterfaceC2103eI interfaceC2103eI, InterfaceC0793Of interfaceC0793Of) {
        Object objQ = abstractC1884cb.q(new C4281xO(interfaceC2103eI), interfaceC0793Of);
        return objQ == AbstractC0378Bt.d() ? objQ : FW.a;
    }

    @Override // defpackage.AbstractC1162Za, defpackage.InterfaceC0939Tm
    public Object collect(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of) {
        return n(this, interfaceC0995Vm, interfaceC0793Of);
    }

    @Override // defpackage.AbstractC1162Za
    public Object g(InterfaceC2103eI interfaceC2103eI, InterfaceC0793Of interfaceC0793Of) {
        return o(this, interfaceC2103eI, interfaceC0793Of);
    }

    public final Object p(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0988Vf interfaceC0988Vf, InterfaceC0793Of interfaceC0793Of) {
        Object objC = AbstractC1803bb.c(interfaceC0988Vf, AbstractC1803bb.d(interfaceC0995Vm, interfaceC0793Of.getContext()), null, new a(null), interfaceC0793Of, 4, null);
        return objC == AbstractC0378Bt.d() ? objC : FW.a;
    }

    public abstract Object q(InterfaceC0995Vm interfaceC0995Vm, InterfaceC0793Of interfaceC0793Of);

    @Override // defpackage.AbstractC1162Za
    public String toString() {
        return this.d + " -> " + super.toString();
    }
}
