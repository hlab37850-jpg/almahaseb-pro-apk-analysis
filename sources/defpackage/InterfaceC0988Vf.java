package defpackage;

import com.itextpdf.text.Annotation;

/* JADX INFO: renamed from: Vf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC0988Vf {

    /* JADX INFO: renamed from: Vf$a */
    public static final class a {

        /* JADX INFO: renamed from: Vf$a$a, reason: collision with other inner class name */
        public static final class C0022a extends AbstractC2233fv implements InterfaceC0526Fp {
            public static final C0022a a = new C0022a();

            public C0022a() {
                super(2);
            }

            @Override // defpackage.InterfaceC0526Fp
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC0988Vf mo13invoke(InterfaceC0988Vf interfaceC0988Vf, b bVar) {
                C0618Jd c0618Jd;
                AbstractC4492zt.h(interfaceC0988Vf, "acc");
                AbstractC4492zt.h(bVar, "element");
                InterfaceC0988Vf interfaceC0988VfMinusKey = interfaceC0988Vf.minusKey(bVar.getKey());
                C1172Zk c1172Zk = C1172Zk.a;
                if (interfaceC0988VfMinusKey == c1172Zk) {
                    return bVar;
                }
                InterfaceC0854Qf.b bVar2 = InterfaceC0854Qf.o;
                InterfaceC0854Qf interfaceC0854Qf = (InterfaceC0854Qf) interfaceC0988VfMinusKey.get(bVar2);
                if (interfaceC0854Qf == null) {
                    c0618Jd = new C0618Jd(interfaceC0988VfMinusKey, bVar);
                } else {
                    InterfaceC0988Vf interfaceC0988VfMinusKey2 = interfaceC0988VfMinusKey.minusKey(bVar2);
                    if (interfaceC0988VfMinusKey2 == c1172Zk) {
                        return new C0618Jd(bVar, interfaceC0854Qf);
                    }
                    c0618Jd = new C0618Jd(new C0618Jd(interfaceC0988VfMinusKey2, bVar), interfaceC0854Qf);
                }
                return c0618Jd;
            }
        }

        public static InterfaceC0988Vf a(InterfaceC0988Vf interfaceC0988Vf, InterfaceC0988Vf interfaceC0988Vf2) {
            AbstractC4492zt.h(interfaceC0988Vf2, "context");
            return interfaceC0988Vf2 == C1172Zk.a ? interfaceC0988Vf : (InterfaceC0988Vf) interfaceC0988Vf2.fold(interfaceC0988Vf, C0022a.a);
        }
    }

    /* JADX INFO: renamed from: Vf$b */
    public interface b extends InterfaceC0988Vf {

        /* JADX INFO: renamed from: Vf$b$a */
        public static final class a {
            public static Object a(b bVar, Object obj, InterfaceC0526Fp interfaceC0526Fp) {
                AbstractC4492zt.h(interfaceC0526Fp, Annotation.OPERATION);
                return interfaceC0526Fp.mo13invoke(obj, bVar);
            }

            public static b b(b bVar, c cVar) {
                AbstractC4492zt.h(cVar, "key");
                if (!AbstractC4492zt.d(bVar.getKey(), cVar)) {
                    return null;
                }
                AbstractC4492zt.f(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static InterfaceC0988Vf c(b bVar, c cVar) {
                AbstractC4492zt.h(cVar, "key");
                return AbstractC4492zt.d(bVar.getKey(), cVar) ? C1172Zk.a : bVar;
            }

            public static InterfaceC0988Vf d(b bVar, InterfaceC0988Vf interfaceC0988Vf) {
                AbstractC4492zt.h(interfaceC0988Vf, "context");
                return a.a(bVar, interfaceC0988Vf);
            }
        }

        @Override // defpackage.InterfaceC0988Vf
        b get(c cVar);

        c getKey();
    }

    /* JADX INFO: renamed from: Vf$c */
    public interface c {
    }

    Object fold(Object obj, InterfaceC0526Fp interfaceC0526Fp);

    b get(c cVar);

    InterfaceC0988Vf minusKey(c cVar);

    InterfaceC0988Vf plus(InterfaceC0988Vf interfaceC0988Vf);
}
