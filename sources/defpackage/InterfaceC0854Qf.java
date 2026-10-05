package defpackage;

/* JADX INFO: renamed from: Qf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC0854Qf extends InterfaceC0988Vf.b {
    public static final b o = b.a;

    /* JADX INFO: renamed from: Qf$a */
    public static final class a {
        public static InterfaceC0988Vf.b a(InterfaceC0854Qf interfaceC0854Qf, InterfaceC0988Vf.c cVar) {
            AbstractC4492zt.h(cVar, "key");
            if (!(cVar instanceof I)) {
                if (InterfaceC0854Qf.o != cVar) {
                    return null;
                }
                AbstractC4492zt.f(interfaceC0854Qf, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return interfaceC0854Qf;
            }
            I i = (I) cVar;
            if (!i.a(interfaceC0854Qf.getKey())) {
                return null;
            }
            InterfaceC0988Vf.b bVarB = i.b(interfaceC0854Qf);
            if (bVarB instanceof InterfaceC0988Vf.b) {
                return bVarB;
            }
            return null;
        }

        public static InterfaceC0988Vf b(InterfaceC0854Qf interfaceC0854Qf, InterfaceC0988Vf.c cVar) {
            AbstractC4492zt.h(cVar, "key");
            if (!(cVar instanceof I)) {
                return InterfaceC0854Qf.o == cVar ? C1172Zk.a : interfaceC0854Qf;
            }
            I i = (I) cVar;
            return (!i.a(interfaceC0854Qf.getKey()) || i.b(interfaceC0854Qf) == null) ? interfaceC0854Qf : C1172Zk.a;
        }
    }

    /* JADX INFO: renamed from: Qf$b */
    public static final class b implements InterfaceC0988Vf.c {
        public static final /* synthetic */ b a = new b();
    }

    InterfaceC0793Of interceptContinuation(InterfaceC0793Of interfaceC0793Of);

    void releaseInterceptedContinuation(InterfaceC0793Of interfaceC0793Of);
}
