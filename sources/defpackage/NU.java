package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NU {

    public static final class a extends AbstractC0819Pf {
        public long a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int e;

        public a(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return NU.d(0L, null, this);
        }
    }

    public static final KU a(long j, InterfaceC1830bu interfaceC1830bu) {
        return new KU("Timed out waiting for " + j + " ms", interfaceC1830bu);
    }

    public static final Object b(LU lu, InterfaceC0526Fp interfaceC0526Fp) {
        AbstractC3347lu.i(lu, AbstractC1043Xi.b(lu.c.getContext()).d(lu.d, lu, lu.getContext()));
        return AbstractC4461zW.c(lu, lu, interfaceC0526Fp);
    }

    public static final Object c(long j, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        if (j <= 0) {
            throw new KU("Timed out immediately");
        }
        Object objB = b(new LU(j, interfaceC0793Of), interfaceC0526Fp);
        if (objB == AbstractC0378Bt.d()) {
            AbstractC3416mi.c(interfaceC0793Of);
        }
        return objB;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object d(long j, InterfaceC0526Fp interfaceC0526Fp, InterfaceC0793Of interfaceC0793Of) {
        a aVar;
        OJ oj;
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
        Object obj = aVar.d;
        Object objD = AbstractC0378Bt.d();
        int i2 = aVar.e;
        if (i2 == 0) {
            LL.b(obj);
            if (j <= 0) {
                return null;
            }
            OJ oj2 = new OJ();
            try {
                aVar.b = interfaceC0526Fp;
                aVar.c = oj2;
                aVar.a = j;
                aVar.e = 1;
                LU lu = new LU(j, aVar);
                oj2.a = lu;
                Object objB = b(lu, interfaceC0526Fp);
                if (objB == AbstractC0378Bt.d()) {
                    AbstractC3416mi.c(aVar);
                }
                return objB == objD ? objD : objB;
            } catch (KU e) {
                e = e;
                oj = oj2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            oj = (OJ) aVar.c;
            try {
                LL.b(obj);
                return obj;
            } catch (KU e2) {
                e = e2;
            }
        }
        if (e.a == oj.a) {
            return null;
        }
        throw e;
    }
}
