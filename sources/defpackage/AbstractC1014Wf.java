package defpackage;

/* JADX INFO: renamed from: Wf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1014Wf {

    /* JADX INFO: renamed from: Wf$a */
    public static final class a extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final a a = new a();

        public a() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC0988Vf mo13invoke(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0988Vf.b bVar) {
            return interfaceC0988Vf.plus(bVar);
        }
    }

    /* JADX INFO: renamed from: Wf$b */
    public static final class b extends AbstractC2233fv implements InterfaceC0526Fp {
        public final /* synthetic */ OJ a;
        public final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(OJ oj, boolean z) {
            super(2);
            this.a = oj;
            this.b = z;
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC0988Vf mo13invoke(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0988Vf.b bVar) {
            return interfaceC0988Vf.plus(bVar);
        }
    }

    /* JADX INFO: renamed from: Wf$c */
    public static final class c extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final c a = new c();

        public c() {
            super(2);
        }

        public final Boolean a(boolean z, InterfaceC0988Vf.b bVar) {
            return Boolean.valueOf(z);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return a(((Boolean) obj).booleanValue(), (InterfaceC0988Vf.b) obj2);
        }
    }

    public static final InterfaceC0988Vf a(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0988Vf interfaceC0988Vf2, boolean z) {
        boolean zC = c(interfaceC0988Vf);
        boolean zC2 = c(interfaceC0988Vf2);
        if (!zC && !zC2) {
            return interfaceC0988Vf.plus(interfaceC0988Vf2);
        }
        OJ oj = new OJ();
        oj.a = interfaceC0988Vf2;
        C1172Zk c1172Zk = C1172Zk.a;
        InterfaceC0988Vf interfaceC0988Vf3 = (InterfaceC0988Vf) interfaceC0988Vf.fold(c1172Zk, new b(oj, z));
        if (zC2) {
            oj.a = ((InterfaceC0988Vf) oj.a).fold(c1172Zk, a.a);
        }
        return interfaceC0988Vf3.plus((InterfaceC0988Vf) oj.a);
    }

    public static final String b(InterfaceC0988Vf interfaceC0988Vf) {
        return null;
    }

    public static final boolean c(InterfaceC0988Vf interfaceC0988Vf) {
        return ((Boolean) interfaceC0988Vf.fold(Boolean.FALSE, c.a)).booleanValue();
    }

    public static final InterfaceC0988Vf d(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0988Vf interfaceC0988Vf2) {
        return !c(interfaceC0988Vf2) ? interfaceC0988Vf.plus(interfaceC0988Vf2) : a(interfaceC0988Vf, interfaceC0988Vf2, false);
    }

    public static final InterfaceC0988Vf e(InterfaceC2052dg interfaceC2052dg, InterfaceC0988Vf interfaceC0988Vf) {
        InterfaceC0988Vf interfaceC0988VfA = a(interfaceC2052dg.getCoroutineContext(), interfaceC0988Vf, true);
        return (interfaceC0988VfA == C0368Bj.a() || interfaceC0988VfA.get(InterfaceC0854Qf.o) != null) ? interfaceC0988VfA : interfaceC0988VfA.plus(C0368Bj.a());
    }

    public static final C4370yW f(InterfaceC2297gg interfaceC2297gg) {
        while (!(interfaceC2297gg instanceof C4148vj) && (interfaceC2297gg = interfaceC2297gg.getCallerFrame()) != null) {
            if (interfaceC2297gg instanceof C4370yW) {
                return (C4370yW) interfaceC2297gg;
            }
        }
        return null;
    }

    public static final C4370yW g(InterfaceC0793Of interfaceC0793Of, InterfaceC0988Vf interfaceC0988Vf, Object obj) {
        if (!(interfaceC0793Of instanceof InterfaceC2297gg) || interfaceC0988Vf.get(AW.a) == null) {
            return null;
        }
        C4370yW c4370yWF = f((InterfaceC2297gg) interfaceC0793Of);
        if (c4370yWF != null) {
            c4370yWF.J0(interfaceC0988Vf, obj);
        }
        return c4370yWF;
    }
}
