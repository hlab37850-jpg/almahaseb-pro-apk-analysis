package defpackage;

/* JADX INFO: renamed from: cI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1864cI {

    /* JADX INFO: renamed from: cI$a */
    public static final class a extends AbstractC0819Pf {
        public Object a;
        public Object b;
        public /* synthetic */ Object c;
        public int d;

        public a(InterfaceC0793Of interfaceC0793Of) {
            super(interfaceC0793Of);
        }

        @Override // defpackage.AbstractC2171f7
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return AbstractC1864cI.a(null, null, this);
        }
    }

    /* JADX INFO: renamed from: cI$b */
    public static final class b extends AbstractC2233fv implements InterfaceC3750qp {
        public final /* synthetic */ InterfaceC4293xa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC4293xa interfaceC4293xa) {
            super(1);
            this.a = interfaceC4293xa;
        }

        @Override // defpackage.InterfaceC3750qp
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return FW.a;
        }

        public final void invoke(Throwable th) {
            InterfaceC4293xa interfaceC4293xa = this.a;
            KL.a aVar = KL.a;
            interfaceC4293xa.resumeWith(KL.a(FW.a));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(InterfaceC2103eI interfaceC2103eI, InterfaceC3588op interfaceC3588op, InterfaceC0793Of interfaceC0793Of) throws Throwable {
        a aVar;
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
        Object obj = aVar.c;
        Object objD = AbstractC0378Bt.d();
        int i2 = aVar.d;
        try {
            if (i2 == 0) {
                LL.b(obj);
                if (aVar.getContext().get(InterfaceC1830bu.s) != interfaceC2103eI) {
                    throw new IllegalStateException("awaitClose() can only be invoked from the producer context");
                }
                aVar.a = interfaceC2103eI;
                aVar.b = interfaceC3588op;
                aVar.d = 1;
                C4374ya c4374ya = new C4374ya(AbstractC0352At.c(aVar), 1);
                c4374ya.A();
                interfaceC2103eI.invokeOnClose(new b(c4374ya));
                Object objX = c4374ya.x();
                if (objX == AbstractC0378Bt.d()) {
                    AbstractC3416mi.c(aVar);
                }
                if (objX == objD) {
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC3588op = (InterfaceC3588op) aVar.b;
                LL.b(obj);
            }
            interfaceC3588op.invoke();
            return FW.a;
        } catch (Throwable th) {
            interfaceC3588op.invoke();
            throw th;
        }
    }

    public static final IJ b(InterfaceC2052dg interfaceC2052dg, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8, EnumC2379hg enumC2379hg, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp) {
        C2022dI c2022dI = new C2022dI(AbstractC1014Wf.e(interfaceC2052dg, interfaceC0988Vf), AbstractC2287gb.b(i, i8, null, 4, null));
        if (interfaceC3750qp != null) {
            c2022dI.C(interfaceC3750qp);
        }
        c2022dI.G0(enumC2379hg, c2022dI, interfaceC0526Fp);
        return c2022dI;
    }

    public static final IJ c(InterfaceC2052dg interfaceC2052dg, InterfaceC0988Vf interfaceC0988Vf, int i, InterfaceC0526Fp interfaceC0526Fp) {
        return b(interfaceC2052dg, interfaceC0988Vf, i, I8.SUSPEND, EnumC2379hg.DEFAULT, null, interfaceC0526Fp);
    }

    public static /* synthetic */ IJ d(InterfaceC2052dg interfaceC2052dg, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8, EnumC2379hg enumC2379hg, InterfaceC3750qp interfaceC3750qp, InterfaceC0526Fp interfaceC0526Fp, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            interfaceC0988Vf = C1172Zk.a;
        }
        InterfaceC0988Vf interfaceC0988Vf2 = interfaceC0988Vf;
        int i3 = (i2 & 2) != 0 ? 0 : i;
        if ((i2 & 4) != 0) {
            i8 = I8.SUSPEND;
        }
        I8 i9 = i8;
        if ((i2 & 8) != 0) {
            enumC2379hg = EnumC2379hg.DEFAULT;
        }
        EnumC2379hg enumC2379hg2 = enumC2379hg;
        if ((i2 & 16) != 0) {
            interfaceC3750qp = null;
        }
        return b(interfaceC2052dg, interfaceC0988Vf2, i3, i9, enumC2379hg2, interfaceC3750qp, interfaceC0526Fp);
    }
}
