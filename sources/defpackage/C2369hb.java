package defpackage;

import java.util.Iterator;

/* JADX INFO: renamed from: hb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C2369hb extends AbstractC1162Za {
    public final Iterable d;

    /* JADX INFO: renamed from: hb$a */
    public static final class a extends XS implements InterfaceC0526Fp {
        public int a;
        public final /* synthetic */ InterfaceC0939Tm b;
        public final /* synthetic */ C4281xO c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC0939Tm interfaceC0939Tm, C4281xO c4281xO, InterfaceC0793Of interfaceC0793Of) {
            super(2, interfaceC0793Of);
            this.b = interfaceC0939Tm;
            this.c = c4281xO;
        }

        @Override // defpackage.AbstractC2171f7
        public final InterfaceC0793Of create(Object obj, InterfaceC0793Of interfaceC0793Of) {
            return new a(this.b, this.c, interfaceC0793Of);
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
                C4281xO c4281xO = this.c;
                this.a = 1;
                if (interfaceC0939Tm.collect(c4281xO, this) == objD) {
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

    public /* synthetic */ C2369hb(Iterable iterable, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8, int i2, AbstractC0419Di abstractC0419Di) {
        this(iterable, (i2 & 2) != 0 ? C1172Zk.a : interfaceC0988Vf, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? I8.SUSPEND : i8);
    }

    @Override // defpackage.AbstractC1162Za
    public Object g(InterfaceC2103eI interfaceC2103eI, InterfaceC0793Of interfaceC0793Of) {
        C4281xO c4281xO = new C4281xO(interfaceC2103eI);
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            O8.d(interfaceC2103eI, null, null, new a((InterfaceC0939Tm) it.next(), c4281xO, null), 3, null);
        }
        return FW.a;
    }

    @Override // defpackage.AbstractC1162Za
    public AbstractC1162Za h(InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        return new C2369hb(this.d, interfaceC0988Vf, i, i8);
    }

    @Override // defpackage.AbstractC1162Za
    public IJ m(InterfaceC2052dg interfaceC2052dg) {
        return AbstractC1864cI.c(interfaceC2052dg, this.a, this.b, k());
    }

    public C2369hb(Iterable iterable, InterfaceC0988Vf interfaceC0988Vf, int i, I8 i8) {
        super(interfaceC0988Vf, i, i8);
        this.d = iterable;
    }
}
