package defpackage;

/* JADX INFO: renamed from: oN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3551oN {

    /* JADX INFO: renamed from: oN$a */
    public static final class a extends AbstractC2233fv implements InterfaceC0526Fp {
        public final /* synthetic */ C3387mN a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C3387mN c3387mN) {
            super(2);
            this.a = c3387mN;
        }

        public final Integer a(int i, InterfaceC0988Vf.b bVar) {
            InterfaceC0988Vf.c key = bVar.getKey();
            InterfaceC0988Vf.b bVar2 = this.a.b.get(key);
            if (key != InterfaceC1830bu.s) {
                return Integer.valueOf(bVar != bVar2 ? Integer.MIN_VALUE : i + 1);
            }
            InterfaceC1830bu interfaceC1830bu = (InterfaceC1830bu) bVar2;
            InterfaceC1830bu interfaceC1830buB = AbstractC3551oN.b((InterfaceC1830bu) bVar, interfaceC1830bu);
            if (interfaceC1830buB == interfaceC1830bu) {
                if (interfaceC1830bu != null) {
                    i++;
                }
                return Integer.valueOf(i);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + interfaceC1830buB + ", expected child of " + interfaceC1830bu + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // defpackage.InterfaceC0526Fp
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo13invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (InterfaceC0988Vf.b) obj2);
        }
    }

    public static final void a(C3387mN c3387mN, InterfaceC0988Vf interfaceC0988Vf) {
        if (((Number) interfaceC0988Vf.fold(0, new a(c3387mN))).intValue() == c3387mN.c) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + c3387mN.b + ",\n\t\tbut emission happened in " + interfaceC0988Vf + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final InterfaceC1830bu b(InterfaceC1830bu interfaceC1830bu, InterfaceC1830bu interfaceC1830bu2) {
        while (interfaceC1830bu != null) {
            if (interfaceC1830bu == interfaceC1830bu2) {
                return interfaceC1830bu;
            }
            if (!(interfaceC1830bu instanceof ON)) {
                return interfaceC1830bu;
            }
            interfaceC1830bu = ((ON) interfaceC1830bu).H0();
        }
        return null;
    }
}
