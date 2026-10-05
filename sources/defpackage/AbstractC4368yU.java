package defpackage;

/* JADX INFO: renamed from: yU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4368yU {
    public static final YS a = new YS("NO_THREAD_ELEMENTS");
    public static final InterfaceC0526Fp b = a.a;
    public static final InterfaceC0526Fp c = b.a;
    public static final InterfaceC0526Fp d = c.a;

    /* JADX INFO: renamed from: yU$a */
    public static final class a extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final a a = new a();

        public a() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo13invoke(Object obj, InterfaceC0988Vf.b bVar) {
            if (!(bVar instanceof InterfaceC4287xU)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    /* JADX INFO: renamed from: yU$b */
    public static final class b extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final b a = new b();

        public b() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC4287xU mo13invoke(InterfaceC4287xU interfaceC4287xU, InterfaceC0988Vf.b bVar) {
            if (interfaceC4287xU != null) {
                return interfaceC4287xU;
            }
            if (bVar instanceof InterfaceC4287xU) {
                return (InterfaceC4287xU) bVar;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: yU$c */
    public static final class c extends AbstractC2233fv implements InterfaceC0526Fp {
        public static final c a = new c();

        public c() {
            super(2);
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CU mo13invoke(CU cu, InterfaceC0988Vf.b bVar) {
            if (bVar instanceof InterfaceC4287xU) {
                InterfaceC4287xU interfaceC4287xU = (InterfaceC4287xU) bVar;
                cu.a(interfaceC4287xU, interfaceC4287xU.updateThreadContext(cu.a));
            }
            return cu;
        }
    }

    public static final void a(InterfaceC0988Vf interfaceC0988Vf, Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof CU) {
            ((CU) obj).b(interfaceC0988Vf);
            return;
        }
        Object objFold = interfaceC0988Vf.fold(null, c);
        if (objFold == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        ((InterfaceC4287xU) objFold).restoreThreadContext(interfaceC0988Vf, obj);
    }

    public static final Object b(InterfaceC0988Vf interfaceC0988Vf) {
        Object objFold = interfaceC0988Vf.fold(0, b);
        AbstractC4492zt.e(objFold);
        return objFold;
    }

    public static final Object c(InterfaceC0988Vf interfaceC0988Vf, Object obj) {
        if (obj == null) {
            obj = b(interfaceC0988Vf);
        }
        if (obj == 0) {
            return a;
        }
        return obj instanceof Integer ? interfaceC0988Vf.fold(new CU(interfaceC0988Vf, ((Number) obj).intValue()), d) : ((InterfaceC4287xU) obj).updateThreadContext(interfaceC0988Vf);
    }
}
